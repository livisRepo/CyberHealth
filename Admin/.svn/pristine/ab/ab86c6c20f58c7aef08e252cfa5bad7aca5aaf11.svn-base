var data = require('/Protractor/Admin/CH_Test_data.json');
var coach = require('/Protractor/Admin/register_coach.json');


describe('Coach Management', function(){
    data.forEach(function(testdata){
        //browser.driver.manage().deleteAllCookies();
        protractor.loginHelper.loginPage(testdata.username,testdata.password);
       // console.log('jasmine-version:' + jasmine.version);
    });

    it('Click Coach Management', function(){
        browser.waitForAngular();
        browser.sleep(2000);
        element(by.partialLinkText('Coach Management')).click();


    });

    it('Add Coach', function(){

            coach.forEach(function(coachdata){
                browser.sleep(1000);

            var elem=element(by.css('.classic-title'));
            expect(elem.getText()).toEqual('Coach Management');

            //Click Add Coach Button
            element(by.id('modal_trigger')).click();
             browser.waitForAngular();
            // browser.pause();
            //browser.sleep(1000);
            element(by.model('coach.name')).sendKeys(coachdata.name);


            var email=element(by.model('coach.emailid'));
            email.sendKeys(coachdata.email);

            element(by.model('coach.password')).clear();
            element(by.model('coach.password')).sendKeys(coachdata.password);

            element(by.model('confirm_password')).clear();
            element(by.model('confirm_password')).sendKeys(coachdata.confirmPassword);
            browser.sleep(1000);

            var clickable=element(by.css('[class="btn btn_red"][disabled="disabled"]'));
            var name_req=element(by.css('[class="error-message ng-hide" ][ng-show="coachRegisterForm.coachName.$error.required"]'));
            var name_pattern=element(by.css('[class="error-message ng-hide" ][ng-show="coachRegisterForm.coachName.$error.pattern"]'));
            var email_req=element(by.css('[class="error-message ng-hide" ][ng-show="coachRegisterForm.emailid.$error.required"]'));
            var email_pattern=element(by.css('[class="error-message ng-hide" ][ng-show="coachRegisterForm.emailid.$error.email"]'));
            var email_exists=element(by.css('[class="error-message ng-hide" ][ng-show="coachRegisterForm.emailid.$error.emailexists"]'));
            var password_req=element(by.css('[class="error-message ng-hide" ][ng-show="coachRegisterForm.password.$error.required"]'));
            var password_pattern=element(by.css('[class="error-message ng-hide" ][ng-show="coachRegisterForm.password.$error.pattern"]'));
            var confirm_password_compare=element(by.css('[class="error-message ng-hide" ][ng-show="coachRegisterForm.confirm_password.$error.compareTo"]'));

                clickable.isPresent().then(function(result){

                    if (result) {

                        //check for coach name
                        if (coachdata.name == "") {

                            expect(name_req.isPresent()).toBe(false);
                        }
                        else if (coachdata.name == "admin1") {
                            expect(name_pattern.isPresent()).toBe(false);
                        }

                        //check for coach email
                        if (coachdata.email == "") {
                            expect(email_req.isPresent()).toBe(false);
                        }
                        else if (coachdata.email == "udayakumarl") {
                            expect(email_pattern.isPresent()).toBe(false);
                        }
                        else if (coachdata.email == "sample@gmail.com") {
                            expect(email_exists.isPresent()).toBe(false);
                        }


                        //check for coach password
                        if (coachdata.password == "") {
                            expect(password_req.isPresent()).toBe(false);
                        }
                        else if (coachdata.password == "Deems ys") {
                            expect(password_pattern.isPresent()).toBe(false);
                        }

                        //check for coach confirm password
                        if (coachdata.confirmPassword != coachdata.password) {
                            expect(confirm_password_compare.isPresent()).toBe(false);
                        }

                        element(by.xpath('//*[@id="modal"]/header/span[2]')).click();


                    } else {
                        //browser.sleep(2000);
                        element(by.partialLinkText('Create Coach')).click();
                        console.log('Added Coach name as ' + coachdata.name);
                    }


                });
//we need to click view button and disable button
//need to change in application as search with email of coach also
        });

    });
});