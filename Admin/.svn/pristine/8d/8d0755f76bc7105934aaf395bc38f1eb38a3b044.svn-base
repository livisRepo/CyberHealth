var data = require('/Protractor/Admin/CH_Test_data.json');
var search=function(){
    browser.waitForAngular();
    element(by.css('[class="fa fa-search"]')).click();
    element(by.model('usersearch')).sendKeys('arun.livis@gmail.com');
};
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

    it('Click View Details button', function(){
        search();


        browser.waitForAngular();
        element(by.partialLinkText('View Details')).click();
        browser.waitForAngular();
        element(by.partialLinkText('Back to Members List')).click();
       // search();

    });

   /* it('Click Disable button', function() {
        browser.waitForAngular();
        element(by.partialLinkText('Disable')).click();
       // browser.pause();
    });*/
    var noOfRecords;
    var recordsPerPage;

    it('Count Number of Members', function(){
        element(by.css('[class="table table-striped table-bordered"]')).all(by.css('tr.ng-scope')).count().then(function(count) {

            noOfRecords=parseInt(count);
            console.log('Total Number of Members : '+noOfRecords);
        });

        element.all(by.repeater('user in userfilter')).count().then(function(count) {
            recordsPerPage=parseInt(count);
            console.log('Members per Page : '+recordsPerPage);
            var noOfPages=Math.ceil(parseInt(noOfRecords)/parseInt(recordsPerPage));
            var recordsOfLastPage=parseInt(noOfRecords)%parseInt(recordsPerPage);
            console.log('Total Number of Pages : '+noOfPages);
            if(noOfPages==1){
                console.log('Member of last page : '+noOfRecords);
            }
            else{
                console.log('Member of last page : '+recordsOfLastPage);
            }

        });


    });
    //check with login as disabled user and
    //expect error msg
});