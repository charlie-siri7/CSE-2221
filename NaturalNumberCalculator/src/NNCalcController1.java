import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Controller class.
 *
 * @author Charles Sirichoktanasup
 */
public final class NNCalcController1 implements NNCalcController {

    /**
     * Model object.
     */
    private final NNCalcModel model;

    /**
     * View object.
     */
    private final NNCalcView view;

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(NNCalcModel model,
            NNCalcView view) {
        /*
         * Get model info
         */
        NaturalNumber top = model.top();
        NaturalNumber bottom = model.bottom();
        /*
         * Set NaturalNumber for the maximum integer value so that if a power or
         * root can't be taken to values above this number
         */
        NaturalNumber intMax = new NaturalNumber2(Integer.MAX_VALUE);

        /*
         * Update view to reflect changes in model
         */
        view.updateTopDisplay(top);
        view.updateBottomDisplay(bottom);
        /*
         * You can't subtract a greater number from a lesser number - it results
         * in a negative, which isn't a natural number.
         */
        view.updateSubtractAllowed(top.compareTo(bottom) >= 0);
        /*
         * You can't divide by zero.
         */
        view.updateDivideAllowed(!bottom.isZero());
        /*
         * Root must be greater than 2 and number to take the root of must not
         * be 0. Root can't be taken if the root value exceeds the maximum
         * integer value.
         */
        view.updateRootAllowed(bottom.compareTo(new NaturalNumber2(1)) > 0
                && bottom.compareTo(intMax) < 0);
        /*
         * Can't take a power greater than the maximum integer value.
         */
        view.updatePowerAllowed(bottom.compareTo(intMax) < 0);
    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public NNCalcController1(NNCalcModel model, NNCalcView view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }

    @Override
    public void processClearEvent() {
        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSwapEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processEnterEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        top.copyFrom(bottom);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processAddEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.add(top);
        top.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSubtractEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        top.subtract(bottom);
        bottom.transferFrom(top);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processMultiplyEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.multiply(top);
        top.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processDivideEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber remainder = top.divide(bottom);
        bottom.transferFrom(top);
        top.transferFrom(remainder);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processPowerEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber temp = new NaturalNumber2(top);
        temp.power(bottom.toInt());
        bottom.transferFrom(temp);
        top.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processRootEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        root(top, bottom.toInt());
        bottom.transferFrom(top);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processAddNewDigitEvent(int digit) {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.multiplyBy10(digit);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    /**
     * Returns {@code n} to the power {@code p}.
     *
     * @param n
     *            the number to which we want to apply the power
     * @param p
     *            the power
     * @return the number to the power
     * @requires 0 <= n ^ (p) <= max value of NaturalNumber and p >= 0
     * @ensures power = n ^ (p)
     */
    private static NaturalNumber power(NaturalNumber n, int p) {
        NaturalNumber returnNumber = new NaturalNumber2(n);
        returnNumber.power(p);
        return returnNumber;
    }

    /**
     * Updates {@code n} to the {@code r}-th root of its incoming value.
     *
     * @param n
     *            the number whose root to compute
     * @param r
     *            root
     * @updates n
     * @requires r >= 2
     * @ensures n ^ (r) <= #n < (n + 1) ^ (r)
     */
    public static void root(NaturalNumber n, int r) {
        assert n != null : "Violation of: n is  not null";
        assert r >= 2 : "Violation of: r >= 2";

        // Declare NaturalNumbers for 1 and 2
        NaturalNumber one = new NaturalNumber2(1);
        NaturalNumber two = new NaturalNumber2(2);
        // Set NaturalNumber for tooHigh to n and then add 1
        NaturalNumber tooHigh = new NaturalNumber2(n);
        tooHigh.add(one);
        // Set NaturalNumber for lowEnough to 0
        NaturalNumber lowEnough = new NaturalNumber2(0);
        // Store the original value of n in oldN NaturalNumber
        NaturalNumber oldN = new NaturalNumber2(n);
        // Copy value of tooHigh to n
        n.copyFrom(tooHigh);
        // Add lowEnough to n and then divide by 2 to make n the midpoint
        // between tooHigh and lowEnough
        n.add(lowEnough);
        n.divide(two);
        // initialize rootIsValid to false
        boolean rootIsValid = false;
        // Run while loop while rooIsValid = false
        while (!rootIsValid) {
            // Set values for root + 1 and the difference between tooHigh and
            // lowEnough for each iteration of while loop
            NaturalNumber nPlusOne = new NaturalNumber2(n);
            nPlusOne.add(one);
            NaturalNumber boundDifference = new NaturalNumber2(tooHigh);
            boundDifference.subtract(lowEnough);
            // check if n^r > original value of n
            if (power(n, r).compareTo(oldN) >= 1) {
                // Use temp to temporarily store tooHigh to swap tooHigh and n
                NaturalNumber temp = new NaturalNumber2(tooHigh);
                // Swap values of tooHigh and n
                tooHigh.copyFrom(n);
                n.copyFrom(temp);
                // add lowEnough to n and divide by 2 to make n the midpoint
                // between tooHigh and lowEnough
                n.add(lowEnough);
                n.divide(two);
                // check if (n+1)^r <= original value of n
            } else if (power(nPlusOne, r).compareTo(oldN) <= 0) {
                // set lowEnough to n
                lowEnough.copyFrom(n);
                // set n to the value of tooHigh
                n.copyFrom(tooHigh);
                // add lowEnough to n and divide by 2 to make n the midpoint
                // between tooHigh and lowEnough
                n.add(lowEnough);
                n.divide(two);
                // check if the difference between tooHigh and lowEnough <= 1
            } else if (boundDifference.compareTo(one) <= 0) {
                // copy value of lowEnough to n
                n.copyFrom(lowEnough);
                // set rootIsValid to true to exit loop
                rootIsValid = true;
                // run if no above conditions are met
            } else {
                // set rootIsValid to true to exit loop
                rootIsValid = true;
            }
        }
    }

}
