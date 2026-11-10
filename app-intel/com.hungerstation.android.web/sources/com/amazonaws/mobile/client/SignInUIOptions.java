package com.amazonaws.mobile.client;

import android.app.Activity;

/* loaded from: classes7.dex */
public class SignInUIOptions {
    private final Builder builder;

    public static class Builder {
        private Integer backgroundColor;
        private boolean canCancel;
        private Integer logo;
        private Class<? extends Activity> nextActivityClass;

        public Builder backgroundColor(Integer num) {
            this.backgroundColor = num;
            return this;
        }

        public SignInUIOptions build() {
            return new SignInUIOptions(this);
        }

        public Builder canCancel(boolean z12) {
            this.canCancel = z12;
            return this;
        }

        public Builder logo(Integer num) {
            this.logo = num;
            return this;
        }

        public Builder nextActivity(Class<? extends Activity> cls) {
            this.nextActivityClass = cls;
            return this;
        }
    }

    SignInUIOptions(Builder builder) {
        this.builder = builder;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean canCancel() {
        return this.builder.canCancel;
    }

    public Integer getBackgroundColor() {
        return this.builder.backgroundColor;
    }

    public Integer getLogo() {
        return this.builder.logo;
    }

    public Class<? extends Activity> nextActivity() {
        return this.builder.nextActivityClass;
    }
}
