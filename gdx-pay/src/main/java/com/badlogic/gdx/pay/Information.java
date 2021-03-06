package com.badlogic.gdx.pay;

import javax.annotation.Nullable;

/**
 * Information about a product that can be purchased provided by a purchase manager. Some methods
 * will return 'null' if requested information is not available.
 *
 * @author noblemaster
 */
public final class Information {

    /**
     * The information returned if a purchase manager does not support information.
     */
    public static final Information UNAVAILABLE = new Information(null, null, null);

    private String localName;
    private String localDescription;
    private String localPricing;

    private Integer priceInCents;

    private String priceCurrencyCode;

    public Information(String localName, String localDescription, String localPricing) {
        this.localName = localName;
        this.localDescription = localDescription;
        this.localPricing = localPricing;
    }

    private Information(Builder builder) {
        localName = builder.localName;
        localDescription = builder.localDescription;
        localPricing = builder.localPricing;
        priceInCents = builder.priceInCents;
        priceCurrencyCode = builder.priceCurrencyCode;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Price in cents.
     * <p>Caution: this field could be null, information is not always available! </p>
     */
    @Nullable
    public Integer getPriceInCents() {
        return priceInCents;
    }

    /**
     * Price currency code.
     * <p>Caution:Note that not all PurchaseManagers set this field!</p>
     * @return
     */
    public String getPriceCurrencyCode() {
        return priceCurrencyCode;
    }

    /**
     * Returns the localized product name or null if not available (PurchaseManager-dependent).
     */
    public String getLocalName() {
        return localName;
    }

    /**
     * Returns the localized product description or null if not available (PurchaseManager-dependent).
     */
    public String getLocalDescription() {
        return localDescription;
    }

    /**
     * Returns the localized product price or null if not available (PurchaseManager-dependent).
     */
    public String getLocalPricing() {
        return localPricing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Information that = (Information) o;

        if (localName != null ? !localName.equals(that.localName) : that.localName != null)
            return false;
        if (localDescription != null ? !localDescription.equals(that.localDescription) : that.localDescription != null)
            return false;
        return !(localPricing != null ? !localPricing.equals(that.localPricing) : that.localPricing != null);

    }

    @Override
    public int hashCode() {
        int result = localName != null ? localName.hashCode() : 0;
        result = 31 * result + (localDescription != null ? localDescription.hashCode() : 0);
        result = 31 * result + (localPricing != null ? localPricing.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Information{" +
                "localName='" + localName + '\'' +
                ", localDescription='" + localDescription + '\'' +
                ", localPricing='" + localPricing + '\'' +
                '}';
    }

    public static final class Builder {
        private String localName;
        private String localDescription;
        private String localPricing;
        private Integer priceInCents;
        private String priceCurrencyCode;

        private Builder() {
        }

        public Builder localName(String val) {
            localName = val;
            return this;
        }

        public Builder localDescription(String val) {
            localDescription = val;
            return this;
        }

        public Builder localPricing(String val) {
            localPricing = val;
            return this;
        }

        public Builder priceInCents(Integer val) {
            priceInCents = val;
            return this;
        }

        public Builder priceCurrencyCode(String val) {
            priceCurrencyCode = val;
            return this;
        }

        public Information build() {
            return new Information(this);
        }
    }
}
