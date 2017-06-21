package Stepik;

import java.util.Arrays;


public class AsciiCharSequence implements CharSequence {

    private final byte value[];

    private int hash;

    public AsciiCharSequence() {
        this.value = new String("").getBytes();
    }

    public AsciiCharSequence(byte value[]) {
        this.value = value;
        this.hash = hashCode();
    }

    public AsciiCharSequence(byte value[], int offset, int count) {
        if (offset < 0) {
            throw new StringIndexOutOfBoundsException(offset);
        }
        if (count <= 0) {
            if (count < 0) {
                throw new StringIndexOutOfBoundsException(count);
            }
            if (offset <= value.length) {
                this.value = "".getBytes();
                return;
            }
        }

        if (offset > value.length - count) {
            throw new StringIndexOutOfBoundsException(offset + count);
        }
        this.value = Arrays.copyOfRange(value, offset, offset+count);
    }

    @Override
    public int length() {
        return value.length;
    }

    @Override
    public char charAt(int index) {
        if ((index < 0) || (index >= value.length)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return (char)value[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (start < 0) {
            throw new StringIndexOutOfBoundsException(start);
        }
        if (end > value.length) {
            throw new StringIndexOutOfBoundsException(end);
        }
        int subLen = end - start;
        if (subLen < 0) {
            throw new StringIndexOutOfBoundsException(subLen);
        }
        return ((start == 0) && (end == value.length)) ? this
                : new AsciiCharSequence(value, start, subLen);
    }

    @Override
    public String toString() {

        return new String(this.value);

    }

}
