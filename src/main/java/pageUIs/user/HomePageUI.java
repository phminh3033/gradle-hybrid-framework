package pageUIs.user;

/*---------------------Chi dung de define cac field va bien---------------------*/
public class HomePageUI {

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
    public static final String REGISTER_LINK = "class=ico-register";
    public static final String LOGIN_LINK = "Class=ico-login";
    public static final String MY_ACCOUNT_LINK = "CLASS=ico-account";
    public static final String LOGOUT_LINK = "Class=ico-logout";
}
