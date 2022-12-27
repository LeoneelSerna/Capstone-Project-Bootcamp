import org.testng.Assert;

public class CustomAssertions extends Assert {
    public static void isValidURL (String expectedURL, String currentURL){
        Assert.assertEquals(currentURL, expectedURL, "The " + currentURL + " is not the expected, try using this: " + expectedURL);
    }

    public static void isValidTitle (String PageTitle, String CurrentTitle){
        Assert.assertEquals(PageTitle, CurrentTitle, "The "+ CurrentTitle +" is note the expected, correct is: " + PageTitle);
    }

    public static void isValidIDNavBar (String IDNavigationBar, String CurrentNavID){
        Assert.assertEquals(IDNavigationBar, CurrentNavID, "The ID is not the expected, correct is: " + IDNavigationBar);
    }

    public static void isValidFooter (String FooterText, String CurrentFooter){
        Assert.assertEquals(FooterText, CurrentFooter, "The footer text is not the expected, correct is: " + FooterText);
    }


}
