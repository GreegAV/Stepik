package Stepik;

        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.Objects;

 class Pair<T extends Object, S extends Object> {
        private T first;
        private S second;

        private Pair(T first, S second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        public static Pair of(Object in, Object string) {
            Pair pair = new Pair(in,string);
            return pair;
        }
    }
