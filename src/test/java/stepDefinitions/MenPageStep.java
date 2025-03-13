package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.CheckOutPage;
import pages.MenPage;
import testBase.common.PageObjectManager;

public class MenPageStep {

    private final MenPage menPage;
    public MenPageStep(PageObjectManager pageObjectManager){
        this.menPage = pageObjectManager.getMePage();
    }
    @Given("Navigate to the Men page")
    public void navigate_to_the_Men_page() {
        menPage.navigateToMenPage();
    }
    @Given("Add the {string} from the Men page")
    public void add_the_from_the_men_page(String product) {
        menPage.addProducts(product);
    }

}
