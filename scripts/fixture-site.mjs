// Deterministic fixture site for Site Intelligence E2E.
// Serves a small "DemoShop" platform on :4599 with pages, a JS
// bundle (React-ish + fetch/axios/GraphQL/WS calls + a fake AWS
// key), CSS with design tokens + source map reference, robots.txt
// (disallowing /admin), a sitemap, and honest security headers.
import http from 'node:http'
import { URL } from 'node:url'

const PORT = 4599

const ROBOTS = `User-agent: *
Disallow: /admin
Sitemap: http://localhost:${PORT}/sitemap.xml
`

const SITEMAP = `<?xml version="1.0" encoding="UTF-8"?>
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
  <loc>http://localhost:${PORT}/</loc>
  <loc>http://localhost:${PORT}/about</loc>
  <loc>http://localhost:${PORT}/products</loc>
  <loc>http://localhost:${PORT}/products/1</loc>
  <loc>http://localhost:${PORT}/products/2</loc>
  <loc>http://localhost:${PORT}/login</loc>
  <loc>http://localhost:${PORT}/blog/post-10</loc>
</urlset>
`

const APP_JS = `// DemoShop bundle (fixture)
var React = { createElement: function () {}, useState: function (s) { return [s, function () {}] } };
var ReactDOM = { render: function () {}, hydrate: function () {} };
function App() {
  var products = React.useState([]);
  fetch('/api/products?page=1').then(function (r) { return r.json() });
  fetch('/api/cart', { method: 'POST', headers: { 'Content-Type': 'application/json' } });
  fetch('/api/orders', { method: 'POST' });
  axios.get('/api/users');
  axios.post('/api/checkout', { cartId: 1 });
  var xhr = new XMLHttpRequest();
  xhr.open("GET", "/api/settings", true);
  var ws = new WebSocket("wss://demo.local/socket");
  var gql = "query GetProducts { products { id title } }";
  var gql2 = "mutation AddToCart { addToCart(productId: 1) { ok } }";
  var routes = [{ path: "/products/:id" }, { path: "/cart" }, { path: "/api/health" }];
  return null;
}
var AWS_KEY = "AKIAIOSFODNN7EXAMPLE";
//# sourceMappingURL=app.js.map
`

const STYLES_CSS = `:root {
  --color-primary: #0ea5e9;
  --spacing-1: 0.25rem; --spacing-2: 0.5rem; --spacing-4: 1rem;
  --radius-md: 0.375rem;
}
body { font-family: Inter, system-ui, sans-serif; color: #1e293b; background: #f8fafc; }
.btn-primary { background: #0ea5e9; color: #0ea5e9; border-radius: 0.375rem; padding: 0.5rem 1rem; }
.card { border: 1px solid #e2e8f0; background: #ffffff; }
.hero { color: #0ea5e9; }
@media (min-width: 768px) { .hero { font-size: 2rem; } }
@media (min-width: 1024px) { .hero { font-size: 2.5rem; } }
`

function page(title, desc, h1, body, extraHead = '') {
  return `<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>${title}</title>
<meta name="description" content="${desc}">
<link rel="canonical" href="http://localhost:${PORT}/">
<meta property="og:title" content="${title}">
<link rel="stylesheet" href="/assets/styles.css">
<script src="/assets/app.js"></script>
${extraHead}
</head>
<body>
<header><nav>
<a href="/">Home</a> <a href="/about">About</a> <a href="/products">Products</a>
<a href="/login">Login</a> <a href="/blog/post-10">Blog</a> <a href="/admin/secret">Admin</a>
</nav></header>
<main><h1>${h1}</h1>${body}</main>
<footer><p>DemoShop fixture</p></footer>
<img src="/logo.png">
</body>
</html>`
}

const HOME = page(
  'DemoShop — fixtures for site intel',
  'A small demo shop used to verify the Site Intelligence engine end to end.',
  'Welcome to DemoShop',
  `<p>Browse our <a href="/products">products</a> or read <a href="/about">about us</a>.</p>
   <ul><li><a href="/products/1">Product one</a></li><li><a href="/products/2">Product two</a></li></ul>
   <img src="/hero.png" alt="hero">`,
  `<script type="application/ld+json">{"@type":"Organization","name":"DemoShop"}</script>`
)

const ABOUT = page('About — DemoShop', 'Who we are.', 'About DemoShop', '<p>We make fixtures.</p>')
const PRODUCTS = page('Products — DemoShop', 'All products.', 'All products', '<ul><li><a href="/products/1">P1</a></li><li><a href="/products/2">P2</a></li></ul>')
const P1 = page('Product one — DemoShop', 'The first product.', 'Product one', '<p>Great product.</p><form action="/cart" method="POST"><input name="qty"><button>Add</button></form>', `<script type="application/ld+json">{"@type":"Product","name":"Product one"}</script>`)
const P2 = page('Product two — DemoShop', 'The second product.', 'Product two', '<p>Also great.</p>')
const LOGIN = page('Login — DemoShop', 'Sign in.', 'Sign in', '<form action="/login" method="POST"><input name="email"><input name="password" type="password"><button>Sign in</button></form>')
const BLOG = page('Post — DemoShop', 'A blog post.', 'Post ten', '<p>Words about things.</p>')
const ADMIN = page('Admin — DemoShop', 'Secret admin.', 'Admin', '<p>Should never be crawled (robots.txt).</p>')

const server = http.createServer((req, res) => {
  const url = new URL(req.url, `http://localhost:${PORT}`)
  const send = (body, type, headers = {}) => {
    res.writeHead(200, { 'Content-Type': type, 'X-Powered-By': 'Express', ...headers })
    res.end(body)
  }
  if (url.pathname === '/robots.txt') return send(ROBOTS, 'text/plain')
  if (url.pathname === '/sitemap.xml') return send(SITEMAP, 'application/xml')
  if (url.pathname === '/assets/app.js') return send(APP_JS, 'application/javascript')
  if (url.pathname === '/assets/styles.css') return send(STYLES_CSS, 'text/css')
  if (url.pathname === '/') return send(HOME, 'text/html')
  if (url.pathname === '/about') return send(ABOUT, 'text/html')
  if (url.pathname === '/products') return send(PRODUCTS, 'text/html')
  if (url.pathname === '/products/1') return send(P1, 'text/html')
  if (url.pathname === '/products/2') return send(P2, 'text/html')
  if (url.pathname === '/login') return send(LOGIN, 'text/html')
  if (url.pathname === '/blog/post-10') return send(BLOG, 'text/html')
  if (url.pathname.startsWith('/admin')) return send(ADMIN, 'text/html')
  res.writeHead(404, { 'Content-Type': 'text/html' })
  res.end('<h1>404</h1>')
})

server.listen(PORT, () => console.log(`fixture site on http://localhost:${PORT}`))
