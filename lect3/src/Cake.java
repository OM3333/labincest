public class Cake implements Food {
    private enum Taste {
        CREAM, CHOCOLATE, BERRY, MIXED
    }

    private Taste taste;
    private double size;
    private double sweetness;

    @Override
    public String toString() {
        return "Cake{" +
                "taste=" + taste +
                ", size=" + size +
                ", sweetness=" + sweetness +
                '}';
    }

    public static class Builder {
        private double size;
        private double sugar;
        private double stevia;
        private boolean chocolate;
        private boolean berry;

        public Builder flour(double weight) {
            this.size = weight * 1.5;
            return this;
        }

        public Builder sugar(double weight) {
            this.sugar = weight;
            return this;
        }

        public Builder stevia(double weight) {
            this.sugar = weight;
            return this;
        }

        private double sweetness() {
            return this.sugar * 0.8 + this.stevia * 5;
        }

        private Taste taste() {
            if(!chocolate && !berry) return Taste.CREAM;
            else if(chocolate && !berry) return Taste.CHOCOLATE;
            else if(!chocolate && berry) return Taste.BERRY;
            else return Taste.MIXED;
        }

        public Builder chocolate() {
            this.chocolate = true;
            return this;
        }

        public Builder berry() {
            this.berry = true;
            return this;
        }

        public Cake build() {
            Cake cake = new Cake();
            cake.size = this.size;
            cake.sweetness = this.sweetness();
            cake.taste = this.taste();
            return cake;
        }

    }
}
