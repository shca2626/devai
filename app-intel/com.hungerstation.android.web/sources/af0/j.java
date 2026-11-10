package af0;

import com.google.android.gms.analytics.ecommerce.ProductAction;

/* loaded from: classes11.dex */
public enum j {
    OTHER("other"),
    USER_ACCOUNT("user_account"),
    ORDER_DETAILS("order_details"),
    CHECKOUT(ProductAction.ACTION_CHECKOUT),
    SHOP_LIST("shop_list"),
    COMPANY_CONTENT("company_content"),
    HOME("home"),
    SHOP_DETAILS("shop_details"),
    PRODUCT_DETAILS("product_details"),
    VOUCHER_WALLET("voucher_wallet"),
    VOUCHER_WALLET_ONBOARDING("voucher_wallet_onboarding");


    /* renamed from: b, reason: collision with root package name */
    private final String f965b;

    j(String str) {
        this.f965b = str;
    }

    public String c() {
        return this.f965b;
    }
}
