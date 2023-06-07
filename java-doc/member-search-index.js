memberSearchIndex = [{"p":"org.recsys.infrastucture.configuration","c":"ApplicationConfig","l":"addInterceptors(InterceptorRegistry)","u":"addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)"},{"p":"org.recsys.controllers","c":"WishlistController","l":"addToWishlist(String, Model, Integer)","u":"addToWishlist(java.lang.String,org.springframework.ui.Model,java.lang.Integer)"},{"p":"org.recsys.DTOs","c":"AddToWishlistDto","l":"AddToWishlistDto()","u":"%3Cinit%3E()"},{"p":"org.recsys.services","c":"UserService","l":"addWishlistItem(String, Integer)","u":"addWishlistItem(java.lang.String,java.lang.Integer)"},{"p":"org.recsys.infrastucture.configuration","c":"ApplicationConfig","l":"ApplicationConfig(SessionRepository)","u":"%3Cinit%3E(org.recsys.repositories.SessionRepository)"},{"p":"org.recsys.interceptors","c":"AuthorizationInterceptor","l":"AuthorizationInterceptor(SessionRepository)","u":"%3Cinit%3E(org.recsys.repositories.SessionRepository)"},{"p":"org.recsys.infrastucture.entities","c":"Category","l":"Category()","u":"%3Cinit%3E()"},{"p":"org.recsys.factories","c":"CookieFactory","l":"CookieFactory()","u":"%3Cinit%3E()"},{"p":"org.recsys.factories","c":"CookieFactory","l":"createSessionCookie(String)","u":"createSessionCookie(java.lang.String)"},{"p":"org.recsys.repositories","c":"SessionRepository","l":"existsByToken(String)","u":"existsByToken(java.lang.String)"},{"p":"org.recsys.controllers","c":"ExplorerController","l":"explorer(String, Model)","u":"explorer(java.lang.String,org.springframework.ui.Model)"},{"p":"org.recsys.controllers","c":"ExplorerController","l":"ExplorerController()","u":"%3Cinit%3E()"},{"p":"org.recsys.repositories","c":"CategoryRepository","l":"findAll()"},{"p":"org.recsys.repositories","c":"UserRepository","l":"findByEmail(String)","u":"findByEmail(java.lang.String)"},{"p":"org.recsys.repositories","c":"CategoryRepository","l":"findByName(String)","u":"findByName(java.lang.String)"},{"p":"org.recsys.repositories","c":"SessionRepository","l":"findByToken(String)","u":"findByToken(java.lang.String)"},{"p":"org.recsys.repositories","c":"ProductRepository","l":"findProductById(Integer)","u":"findProductById(java.lang.Integer)"},{"p":"org.recsys.services","c":"ProductService","l":"getProductById(Integer, String)","u":"getProductById(java.lang.Integer,java.lang.String)"},{"p":"org.recsys.repositories","c":"ProductRepository","l":"getRecommendedProducts(Integer)","u":"getRecommendedProducts(java.lang.Integer)"},{"p":"org.recsys.services","c":"ProductService","l":"getRecommendedProducts(String)","u":"getRecommendedProducts(java.lang.String)"},{"p":"org.recsys.services","c":"ProductService","l":"getSearchedProducts(String, String, Double, Double, Double, Double)","u":"getSearchedProducts(java.lang.String,java.lang.String,java.lang.Double,java.lang.Double,java.lang.Double,java.lang.Double)"},{"p":"org.recsys.services","c":"UserService","l":"getUserByCookieSession(String)","u":"getUserByCookieSession(java.lang.String)"},{"p":"org.recsys.services","c":"UserService","l":"getWishlist(String)","u":"getWishlist(java.lang.String)"},{"p":"org.recsys.controllers","c":"HomeController","l":"home(Model)","u":"home(org.springframework.ui.Model)"},{"p":"org.recsys.controllers","c":"HomeController","l":"HomeController()","u":"%3Cinit%3E()"},{"p":"org.recsys.repositories","c":"ProductRepository","l":"increaseUserProductScore(Integer, Integer, Integer)","u":"increaseUserProductScore(java.lang.Integer,java.lang.Integer,java.lang.Integer)"},{"p":"org.recsys","c":"RecsysApplication","l":"main(String[])","u":"main(java.lang.String[])"},{"p":"org.recsys.interceptors","c":"AuthorizationInterceptor","l":"preHandle(HttpServletRequest, HttpServletResponse, Object)","u":"preHandle(jakarta.servlet.http.HttpServletRequest,jakarta.servlet.http.HttpServletResponse,java.lang.Object)"},{"p":"org.recsys.infrastucture.entities","c":"Product","l":"Product()","u":"%3Cinit%3E()"},{"p":"org.recsys.services","c":"ProductService","l":"ProductService()","u":"%3Cinit%3E()"},{"p":"org.recsys.specifications","c":"ProductSpecifications","l":"ProductSpecifications()","u":"%3Cinit%3E()"},{"p":"org.recsys.DTOs","c":"ProductWishlistItemDto","l":"ProductWishlistItemDto(Product)","u":"%3Cinit%3E(org.recsys.infrastucture.entities.Product)"},{"p":"org.recsys","c":"RecsysApplication","l":"RecsysApplication()","u":"%3Cinit%3E()"},{"p":"org.recsys.controllers","c":"WishlistController","l":"removeFromWishlist(String, Model, Integer)","u":"removeFromWishlist(java.lang.String,org.springframework.ui.Model,java.lang.Integer)"},{"p":"org.recsys.services","c":"UserService","l":"removeWishlistItem(String, Integer)","u":"removeWishlistItem(java.lang.String,java.lang.Integer)"},{"p":"org.recsys.specifications","c":"ProductSpecifications","l":"searchProducts(String, String, Double, Double, Double, Double)","u":"searchProducts(java.lang.String,java.lang.String,java.lang.Double,java.lang.Double,java.lang.Double,java.lang.Double)"},{"p":"org.recsys.controllers","c":"ExplorerController","l":"SearchProducts(String, String, Double, Double, Double, Double, Model)","u":"SearchProducts(java.lang.String,java.lang.String,java.lang.Double,java.lang.Double,java.lang.Double,java.lang.Double,org.springframework.ui.Model)"},{"p":"org.recsys.DTOs","c":"SearchRequestDto","l":"SearchRequestDto()","u":"%3Cinit%3E()"},{"p":"org.recsys.infrastucture.entities","c":"Session","l":"Session()","u":"%3Cinit%3E()"},{"p":"org.recsys.infrastucture.entities","c":"Session","l":"Session(User)","u":"%3Cinit%3E(org.recsys.infrastucture.entities.User)"},{"p":"org.recsys.exceptions","c":"SessionCookieException","l":"SessionCookieException()","u":"%3Cinit%3E()"},{"p":"org.recsys.services","c":"UserService","l":"signin(SigninRequestDto)","u":"signin(org.recsys.DTOs.SigninRequestDto)"},{"p":"org.recsys.controllers","c":"UserController","l":"signin(String, Model)","u":"signin(java.lang.String,org.springframework.ui.Model)"},{"p":"org.recsys.controllers","c":"UserController","l":"signinPost(SigninRequestDto, HttpServletResponse)","u":"signinPost(org.recsys.DTOs.SigninRequestDto,jakarta.servlet.http.HttpServletResponse)"},{"p":"org.recsys.DTOs","c":"SigninRequestDto","l":"SigninRequestDto()","u":"%3Cinit%3E()"},{"p":"org.recsys.services","c":"UserService","l":"signup(SignupRequestDto)","u":"signup(org.recsys.DTOs.SignupRequestDto)"},{"p":"org.recsys.controllers","c":"UserController","l":"signup(String, Model)","u":"signup(java.lang.String,org.springframework.ui.Model)"},{"p":"org.recsys.controllers","c":"UserController","l":"signupPost(SignupRequestDto, HttpServletResponse)","u":"signupPost(org.recsys.DTOs.SignupRequestDto,jakarta.servlet.http.HttpServletResponse)"},{"p":"org.recsys.DTOs","c":"SignupRequestDto","l":"SignupRequestDto()","u":"%3Cinit%3E()"},{"p":"org.recsys.controllers","c":"ExplorerController","l":"singleProduct(String, Model, Integer)","u":"singleProduct(java.lang.String,org.springframework.ui.Model,java.lang.Integer)"},{"p":"org.recsys.DTOs","c":"SingleProductDto","l":"SingleProductDto(Product)","u":"%3Cinit%3E(org.recsys.infrastucture.entities.Product)"},{"p":"org.recsys.infrastucture.entities","c":"User","l":"User()","u":"%3Cinit%3E()"},{"p":"org.recsys.infrastucture.entities","c":"User","l":"User(String, String)","u":"%3Cinit%3E(java.lang.String,java.lang.String)"},{"p":"org.recsys.controllers","c":"UserController","l":"UserController(UserService)","u":"%3Cinit%3E(org.recsys.services.UserService)"},{"p":"org.recsys.services","c":"UserService","l":"UserService(UserRepository, SessionRepository, ProductRepository)","u":"%3Cinit%3E(org.recsys.repositories.UserRepository,org.recsys.repositories.SessionRepository,org.recsys.repositories.ProductRepository)"},{"p":"org.recsys.exceptions","c":"UserSigninException","l":"UserSigninException()","u":"%3Cinit%3E()"},{"p":"org.recsys.exceptions","c":"UserSignupException","l":"UserSignupException(String)","u":"%3Cinit%3E(java.lang.String)"},{"p":"org.recsys.controllers","c":"HomeController","l":"welcome(Model)","u":"welcome(org.springframework.ui.Model)"},{"p":"org.recsys.controllers","c":"WishlistController","l":"wishlist(String, Model)","u":"wishlist(java.lang.String,org.springframework.ui.Model)"},{"p":"org.recsys.controllers","c":"WishlistController","l":"WishlistController(UserService)","u":"%3Cinit%3E(org.recsys.services.UserService)"}];updateSearchResults();