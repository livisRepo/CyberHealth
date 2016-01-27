var data = require('/Protractor/CH_Test_data.json')

describe('login Page', function(){

    beforeEach(function() {
        browser.driver.manage().window().maximize()
        browser.get('http://192.168.1.236/cyberhealth/#/index');

    });

    data.forEach(function(testdata) {

        /*it('Go to login page', function () {

            element(by.id('modal_trigger')).click();
        });*/
        it('Login data ', function () {

            element(by.id('modal_trigger')).click();
            element(by.name('username')).sendKeys(testdata.username);
            element(by.name('password')).sendKeys(testdata.password);
            element(by.css('[ng-click="doLogin()"]')).click();

            /*browser.driver.wait(function() {
             return element(by.binding('username')).isPresent();
             }, 10000);*/
            console.log(jasmine.version+" :Jasmin");
            console.log('Name is '+testdata.name1)


            browser.waitForAngular();
            var canvas = element(by.linkText(testdata.name1));

            browser.driver.actions().mouseMove(canvas).click().perform();

           browser.sleep(2000)


            element(by.partialLinkText('Log Out')).click();

        });

    });
});