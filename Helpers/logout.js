exports.logoutPage=function() {


    it('Logout from website', function () {


        var canvas = element(by.css('.drop'));

        browser.driver.actions().mouseMove(canvas).click().perform();

        browser.sleep(2000)


        element(by.partialLinkText('Log Out')).click();


    });
};