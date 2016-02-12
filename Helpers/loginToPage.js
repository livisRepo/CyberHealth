exports.loginPage=function(username,password){


    it('Login with Data', function(){
        browser.driver.manage().window().maximize()
        browser.get('http://192.168.1.236/cyberhealth/#/index');
        browser.waitForAngular();
        //browser.sleep(2000);
        element(by.partialLinkText('Login / Register')).click();

        element(by.name('username')).sendKeys(username);
        element(by.name('password')).sendKeys(password);
        element(by.css('[class="btn btn_red"][ng-click="doLogin()"]')).click();

    });
};