import { spawn } from 'node:child_process'
const dir = '/home/z/my-project/.app-intel/cmw9st6ut0005ksvlzovvp0a1'
const args = ['/home/z/my-project/scripts/deep-analyze.py', '--dir', dir, '--developer-domain', 'fluffychat.im']
const child = spawn('python3', args, { env: { ...process.env, HOME: process.env.HOME ?? '/home/z' } })
let out = '', err = ''
child.stdout.on('data', (d) => (out += d))
child.stderr.on('data', (d) => (err += d))
child.on('close', (code) => {
  console.log('exit code:', code)
  console.log('stdout tail:', out.trim().split('\n').pop()?.slice(0, 120))
  console.log('stderr:', err.slice(0, 500))
})
child.on('error', (e) => console.log('spawn error:', e.message))
