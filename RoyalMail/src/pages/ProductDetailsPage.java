package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	
	WebDriver driver;
	//Breadcrumbs for product
	@FindBy(css = ".breadcrumbs") public WebElement productBreadcrumbs;
	//Product Name
	@FindBy(css = ".page-title") public static WebElement productNameText;
	//Product sku
	@FindBy (css = "div.value:nth-child(2)") public WebElement productSKUText;
	//Issue Date code of product
	@FindBy(css = "div.product:nth-child(4) > div:nth-child(2)") public WebElement productIssueDateText;
	//Product Description text on right
	@FindBy(css = "div.product:nth-child(5)") public WebElement productDescriptionText;
	//In Stock / Out of Stock text
	@FindBy(css = "div.stock:nth-child(1)") public WebElement productStockStatusText;
	//Delivery Estimate text
	@FindBy(css = "div.attribute:nth-child(2)") public WebElement productDeliveryEstimateText;
	//Product price in £XX.XX text format
	@FindBy(css = ".price") public WebElement productPriceText;
	//Order Quantity input Text Box
	@FindBy(id = "qty") public WebElement productOrderQtyBox;
	//Add to basket button
	@FindBy(id = "product-addtocart-button") public WebElement addToBasketButton;
	//Save an item to Wishlist
	@FindBy(css = ".towishlist") public WebElement saveToWishlistButton;
	//Image block including any other images
	@FindBy(css = ".fotorama-item") public WebElement productImagesBlock;
	//Product Description block text at bottom
	@FindBy(css = ".description > div:nth-child(1)") public WebElement productDescription2Text;
	
	//******************************
	//GREY MAIL BAGS elements only
	//Grey Mail Bag's options wrapper
	@FindBy(id = "product-options-wrapper") public WebElement mbgOptionsWrapper;
	//Grey Mail Bags First Radio Button - RM collects
	@FindBy(id = "options_5_2") public WebElement mbgOption1Radio;
	//Grey Mail Bags Second Radio Button - Drop Mail Bags
	@FindBy(id = "options_5_3") public WebElement mbgOption2Radio;
	//Grey Mail Bags Second Radio Button required text box
	@FindBy(id = "options_8_text") public WebElement mbgBox;
	//Grey Mail Bags Third Radio Button - I don't know
	@FindBy(id = "options_5_4") public WebElement mbgOption3Radio;
	//******************************
	
	//Share Text next to social media buttons
	@FindBy(css = ".widget-addthis__label-container") public WebElement shareTextButton;
	//Share by Email icon
	@FindBy(css = ".at-icon-email") public WebElement shareEmailButton;
	//Share on FaceBook
	@FindBy(css = ".at-icon-facebook") public WebElement shareFBButton;
	//Share on Twitter
	@FindBy(css = ".at-icon-twitter") public WebElement shareTwitterButton;
	//Share on Pintrest
	@FindBy(css = ".at-icon-pinterest_share") public WebElement sharePinButton;
	//Share by Text (SMS)
	@FindBy(css = ".at-icon-sms") public WebElement shareSMSButton;
	//Share by WhatsApp
	@FindBy(css = ".at-icon-whatsapp") public WebElement shareWhatsAppButton;


	public void inputQty(String qty) {
		productOrderQtyBox.sendKeys(qty);
	}
	
	
	
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
}
