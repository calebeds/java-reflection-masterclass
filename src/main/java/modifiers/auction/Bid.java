package modifiers.auction;

public abstract class Bid {
    protected int price;
    protected String bidderName;

    public int getPrice() {
        return price;
    }

    public String getBidderName() {
        return bidderName;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "price=" + price +
                ", bidderName='" + bidderName + '\'' +
                '}';
    }

    //Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int price;
        private String bidderName;

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder setBidderName(String bidderName) {
            this.bidderName = bidderName;
            return this;
        }

        public Bid build() {
            return new Builder.BidImpl();
        }

        private class BidImpl extends Bid {
            private BidImpl() {
                super.price = Builder.this.price;
                super.bidderName = Builder.this.bidderName;
            }
        }
    }
}

