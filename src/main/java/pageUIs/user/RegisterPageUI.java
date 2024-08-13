package pageUIs.user;

public class RegisterPageUI {

    /*
     *   1 - public:
     *   + KHONG set protected: vi cac class ben ngoai se KHONG dung duoc -> vi KHONG ap dung thua ke
     *   + KHONG set default: ngoai package KHONG dung duoc
     *   + KHONG set private: ngoai package KHONG dung duoc
     *   -> Se co nguoi dung tu RegisterPageObject goi qua HomePageUI -> SAI ve business
     *   -> Giai quyet bang cach thong nhat trong team
     *
     *   2 - static: Co the truy cap pham vi class tu 1 class khac, ma KHONG can KHOI TAO
     *
     *   3 - final: KHONG duoc phep thay doi gia tri khi su dung
     *
     *   JAVA KHONG co keyword CONST (hang so) -> static + final = CONST
     *
     *   4 - String:
     *
     *   5 - Ten bien = Ten cua ELEMENT + loai ELEMENT
     *   + Ten bien cua hang so: Viet HOA va cach nhau boi dau _
     *
     * */

    /* Tranh viec lap lai code
     *  Define 1 lan duy nhat
     *  Man hinh nao quan ly ELEMENT rieng cua man hinh do
     * */

    public static final String FIRSTNAME_TEXTBOX = "css=input[id='FirstName']";
    public static final String LASTNAME_TEXTBOX = "CSS=input[id='LastName']";
    public static final String EMAIL_TEXTBOX = "Css=input[id='Email']";
    public static final String PASSWORD_TEXTBOX = "id=Password";
    public static final String CONFIRM_PASSWORD_TEXTBOX = "id=ConfirmPassword";
    public static final String FIRSTNAME_ERROR_MSG = "ID=FirstName-error";
    public static final String LASTNAME_ERROR_MSG = "id=LastName-error";
    public static final String EMAIL_ERROR_MSG = "id=Email-error";
    public static final String PASSWORD_ERROR_MSG = "id=Password-error";
    public static final String CONFIRM_PASSWORD_ERROR_MSG = "id=ConfirmPassword-error";
    public static final String REGISTRATION_COMPLETED_MSG = "class=result";
    public static final String REGISTER_BUTTON = "id=register-button";
}
