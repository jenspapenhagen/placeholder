package de.papenhagen.utiles;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


/**
 * Represents an immutable, inclusive range between two bounds, {@code lowerBound} and
 * {@code upperBound}. Both bounds may be {@code null}, indicating an unbounded range
 * in one or both directions.
 * <p>
 * A range instance allows for comparison of whether objects or other ranges fall
 * within its bounds or overlap with it.
 *
 * @param <T> The type of the elements in the range. Must be comparable, extending
 *            {@code Comparable<? super T>} to ensure valid comparisons of bounds and
 *            contained elements.
 */
public final class Range<T extends Comparable<? super T>> implements Serializable {

    @Serial private static final long serialVersionUID = -8591250731566891225L;

    private final T lowerBound;

    private final T upperBound;

    /**
     * Constructs a new Range with the specified lower and upper bounds.
     * The bounds define the inclusive range of values.
     *
     * @param lowerBound the lower bound of the range; can be null, which represents no lower constraint
     * @param upperBound the upper bound of the range; can be null, which represents no upper constraint
     * @throws IllegalArgumentException if both bounds are non-null, and the lower bound is greater than the upper bound
     */
    public Range(final T lowerBound, final T upperBound) throws IllegalArgumentException {
        if (lowerBound != null && upperBound != null && lowerBound.compareTo(upperBound) > 0) {
            throw new IllegalArgumentException("lowerBound is greater than upperBound");
        }

        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    /**
     * Checks if the specified object is within the range determined by the lower and upper bounds.
     *
     * @param object the object to check against the range; must not be null
     * @return true if the object is within the range, otherwise false
     * @throws IllegalArgumentException if the specified object is null
     */
    public boolean contains(final T object) throws IllegalArgumentException {
        if (object == null) {
            throw new IllegalArgumentException("object is null");
        }

        if (this.lowerBound != null && object.compareTo(this.lowerBound) < 0) {
            return false;
        }
        return this.upperBound == null || object.compareTo(this.upperBound) <= 0;
    }

    /**
     * Checks if the given range is fully contained within this range.
     * A range is considered fully contained if its lower bound is greater than or equal to this range's
     * lower bound, and its upper bound is less than or equal to this range's upper bound.
     *
     * @param range the range to check; must not be null
     * @return true if the specified range is fully contained within this range, otherwise false
     * @throws IllegalArgumentException if the specified range is null
     */
    public boolean contains(final Range<T> range) throws IllegalArgumentException {
        if (range == null) {
            throw new IllegalArgumentException("range is null");
        }

        if (this.lowerBound != null && (range.lowerBound == null || range.lowerBound.compareTo(this.lowerBound) < 0)) {
            return false;
        }
        return this.upperBound == null || (range.upperBound != null && range.upperBound.compareTo(this.upperBound) <= 0);
    }

    /**
     * Checks if this range overlaps with the specified range.
     * Two ranges overlap if there is any intersection between their boundaries.
     *
     * @param range the range to check for overlap with; must not be null
     * @return true if the specified range overlaps with this range, otherwise false
     * @throws IllegalArgumentException if the specified range is null
     */
    public boolean overlaps(final Range<T> range) throws IllegalArgumentException {
        if (range == null) {
            throw new IllegalArgumentException("range is null");
        }

        if (this.upperBound != null && range.lowerBound != null && this.upperBound.compareTo(range.lowerBound) < 0) {
            return false;
        }
        return this.lowerBound == null || range.upperBound == null || this.lowerBound.compareTo(range.upperBound) <= 0;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Range<?> range = (Range<?>) o;
        return Objects.equals(lowerBound, range.lowerBound) && Objects.equals(upperBound, range.upperBound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lowerBound, upperBound);
    }

    @Override
    public String toString() {
        return "Range[" + this.lowerBound + ", " + this.upperBound + "]";
    }

}
