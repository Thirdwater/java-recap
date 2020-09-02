class Data {

    void example () {

        // Primitive data types:
        byte a;     // 8-bit signed [-128, 127]
        short b;    // 16-bit signed [-32,768, 32,767]
        int c;      // 32-bit signed (+- 2.147 billion)
        long d;     // 64-bit (check oracle doc again)
        float e;    // single-precision 32-bit
        double f;   // double-precision 64-bit
        boolean g;  // {true, false}
        char h;     // one 16-bit unicode character
        String i;   // special case, actually immutable

        // Default values
        // Does not apply to local variables, those will have to be initialised.
        byte a1 = 0;
        short b1 = 0;
        int c1 = 0;
        long d1 = 0L;
        float e1 = 0.0f;
        double f1 = 0.0d;
        boolean g1 = false;
        char h1 = '\u0000';
        String i1 = null;    // Also the same for any other object

        // Literals
        boolean result = true;
        char c2 = 'c';
        byte b2 = 100;
        short s2 = 10000;
        int i2 = 100000;
        long l2 = 1L;    // l also works, but looks too similar to 1
        int hexadecimal = 0x0;
        int binary = 0b0;
        float f2 = 1.0f;    // f, F, d, D
        double d2 = 1.0d;
        double scientific = 1.0e1;
        char unicodeEscape = '\u0108';
        char singleQuoteChar = 'a';
        String doubleQuoteString = "a";

        // Escape sequences (for char and String)
        char backspace = '\b';
        char tab = '\t';
        char lineFeed = '\n';
        char formFeed = '\f';
        char carriageReturn = '\r';
        char singleQuote = '\'';
        char doubleQuote = '\"';
        char backslash = '\\';

    }

}
