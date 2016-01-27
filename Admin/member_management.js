var data = require('/Protractor/Admin/CH_Test_data.json')

describe('Member Management', function(){
    data.forEach(function(testdata){
        protractor.loginHelper.loginPage(testdata.username,testdata.password);
    });

    it('Click Member Management', function(){
        browser.waitForAngular();
        element(by.partialLinkText('Member Management')).click();
        browser.sleep(3000);
        var elem=element(by.css('.classic-title'));
        expect(elem.getText()).toEqual('Member Management');

    });
});