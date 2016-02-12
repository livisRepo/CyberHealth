var data = require('/Protractor/Admin/CH_Test_data.json')

describe('login Page', function(){

data.forEach(function(testdata)
    {
        console.log(testdata.username);
        console.log(testdata.password);
        protractor.loginHelper.loginPage(testdata.username,testdata.password);

    });
        it('Check Admin ', function () {


            browser.waitForAngular();
           // browser.sleep(13000);
            var elem = element.all(by.css('.head')).getText();
            expect(elem).toContain(' Member Management')
            // if(elem ==' Member Management'){
            console.log('Admin Interface');
            browser.sleep(3000);
           // protractor.tooltipHelper.tooltipTitle();

            //var tooltip=require('/Protractor/Helpers/tooltip.js');
            //expect(tooltip.facebook).toEqual('Facebook');

            protractor.logoutHelper.logoutPage();
        });


});