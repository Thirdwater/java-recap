class ExampleClass {

    // Class variable
    static int someStaticField = 0;

    // Instance variable
    int someInstanceField = 0;

    /*
     * Access Modifiers:
     *   Private - Only accessible inside the same class.
     *   Package-private (default) - Only accessible inside the same package.
     *   Protected - Only accessible inside the same class family.
     *   Public - Only accessible inside the same module unless exported.
     */
    private int a;
    int b;
    protected int c;
    public int d;

    // Constructor
    public ExampleClass (int someParameter) {
        // Local variable
        int someLocalVariable;
    }
    // Create using ExampleClass e = new ExampleClass(...);

    static void someStaticMethod () {}
    void someInstanceMethod () {}

}

class SubExampleClass extends ExampleClass {}
// Check using subExampleObject instanceof ExampleClass;

interface ExampleInterface {

    // Requires all methods to be implemented at compile-time.
    public void someMethod ();

}

class SomeImplementation implements ExampleInterface {

    @Override
    public void someMethod () {}

}
