'use strict';

var data = require('/Protractor/CH_Test_data.json')
describe('login Page', function(){

	/*beforeEach(function() {
		browser.driver.manage().window().maximize()
		browser.get('http://192.168.1.236/cyberhealth/#/index');

  });

	it('should have a title', function(){
		
		expect(browser.getTitle()).toEqual('Cyberhealth')

	});*/



	//data.forEach(function(testdata){

		/*it('Go to login page', function(){

			element(by.id('modal_trigger')).click();
		})*/

		it('Login data from external JSON', function(){
			browser.driver.manage().window().maximize()
			browser.get('http://192.168.1.236/cyberhealth/#/index');
			element(by.id('modal_trigger')).click();
			element(by.name('username')).sendKeys(data[2].username);
			element(by.name('password')).sendKeys(data[2].password);
			element(by.css('[ng-click="doLogin()"]')).click()

			/*browser.driver.wait(function() {
				return element(by.binding('username')).isPresent();
			}, 10000)*/;

			browser.sleep(5000)
			browser.actions().mouseMove(element(by.binding('username'))).perform();
		//	console.log(testdata.username)
			element(by.linkText('My Demography')).click()
			browser.sleep(5000)
			element(by.name('bloodpressure')).sendKeys('120')
			//expect(element(by.binding('username')).getText()).toBe('Arun Livis ');
		})

		/*it('Logout of eah user', function(){

			browser.driver.wait(function() {
				return element(by.binding('username')).isPresent();
			});

			element(by.binding('username')).click()
			element(by.linkText('Log Out')).click()
		})*/

	//})



});