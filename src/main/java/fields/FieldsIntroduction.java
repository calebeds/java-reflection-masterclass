package fields;

import java.lang.reflect.Field;

public class FieldsIntroduction {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
//        printDeclaredFieldsInto(Movie.MovieStats.class);
//        printDeclaredFieldsInto(Category.class);
        Movie movie = new Movie("Lord of the Rings",
                2001,
                12.99,
                true,
                Category.ADVENTURE);

        printDeclaredFieldsInfo(movie.getClass(), movie);

        Field minPriceStaticField = Movie.class.getDeclaredField("MINIMUM_PRICE");

        System.out.printf("static MININUM_PRICE value :%f", minPriceStaticField.get(null));
    }

    public static <T> void printDeclaredFieldsInfo(Class<? extends T> clazz, T instance) throws IllegalAccessException {
        for(Field field: clazz.getDeclaredFields()) {
            System.out.printf("Field name: %s type : %s%n", field.getName(), field.getType().getName());

            System.out.printf("Is synthetic field: %s,%n", field.isSynthetic());
            System.out.printf("Field value is: %s%n", field.get(instance));
            System.out.println();
        }
    }

    public static class Movie extends Product {
        public static final double MINIMUM_PRICE = 10.99;

        private boolean isReleased;
        private Category category;
        private double actualPrice;

        public Movie(String name, int year, double actualPrice, boolean isReleased, Category category) {
            super(name, year);
            this.isReleased = isReleased;
            this.category = category;
            this.actualPrice = actualPrice;
        }

        // Nested class
        public class MovieStats {
            private final double timesWatched;

            public MovieStats(double timesWatched) {
                this.timesWatched = timesWatched;
            }

            public double getRevenue() {
                return timesWatched * actualPrice;
            }
        }
    }

    public static class Product {
        protected String name;
        protected int year;
        protected double actualPrice;

        public Product(String name, int year) {
            this.name = name;
            this.year = year;
        }
    }

    public enum Category {
        ADVENTURE,
        ACTION,
        COMEDY
    }
}
