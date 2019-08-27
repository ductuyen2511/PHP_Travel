package PageUIs;

public class AccountPageUI {
	public static final String CUSTOMER_NAME_ACCOUNT = "//div[@class = 'row']//h3";
	public static final String BOOKING_STATUS = "//h4//strong[contains(text(), 'Nothing Booked Yet')]";
	public static final String ACCOUNT_DROPDOWN = "//div[@class = 'container']//ul[contains(@class, 'user_menu')]//i[contains(@class, 'icon_set_1_icon-70')]";
	public static final String LOG_OUT_LINK = "//span[@class = 'ink animate']/parent::a/following::ul//a[contains(text(),'Logout')]";
	public static final String MY_PROFILE_LINK = "//span[@class = 'profile-icon']";
	public static final String PASSWORD_ACCOUNT_PAGE = "//input[@name = 'password']";
	public static final String COMFIRM_PASSWORD_ACCOUNT_PAGE = "//input[@name = 'confirmpassword']";
	public static final String SUBMIT_BUTTON = "//button[contains(@class, 'updateprofile')]";
	public static final String UPDATE_MESAAGE_SUCCESSFULLY = "//div[@class = 'accountresult']//div[text() = 'Profile Updated Successfully.']";
	public static final String EMAIL_TEXTBOX = "//input[@name = 'email']";
	
	
	
}
