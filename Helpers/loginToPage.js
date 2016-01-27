exports.loginPage=function(username,password){


    it('Login with Data', function(){
        browser.driver.manage().window().maximize()
        browser.get('http://192.168.1.236/cyberhealth/#/index');
        browser.waitForAngular();
        element(by.id('modal_trigger')).click();

        element(by.name('username')).sendKeys(username);
        element(by.name('password')).sendKeys(password);
        element(by.css('[class="btn btn_red"][ng-click="doLogin()"]')).click();

    });
};