

describe('Check Tooltip', function(){


    it('Tooltip for social network', function () {

        browser.driver.manage().window().maximize()
        browser.get('http://192.168.1.236/cyberhealth/#/index');
        browser.waitForAngular();

        var facebook=element(by.css('.facebook.itl-tooltip'));
        var twitter=element(by.css('.twitter.itl-tooltip'));
        var google_plus=element(by.css('.google.itl-tooltip'));
        var linkedin=element(by.css('.linkdin.itl-tooltip'));


        browser.driver.actions().mouseMove(facebook).perform();
        browser.sleep(2000);
        expect(facebook.getAttribute('data-original-title')).toBe("Facebook");
        browser.driver.actions().mouseMove(twitter).perform();
        browser.sleep(2000);
        expect(twitter.getAttribute('data-original-title')).toBe("Twitter");
        browser.driver.actions().mouseMove(google_plus).perform();
        browser.sleep(2000);
        expect(google_plus.getAttribute('data-original-title')).toBe("Google Plus");
        browser.driver.actions().mouseMove(linkedin).perform();
        browser.sleep(2000);
        expect(linkedin.getAttribute('data-original-title')).toBe("Linkedin");

    });

});