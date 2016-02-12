
exports.config = {
  framework: 'jasmine',
  seleniumAddress: 'http://localhost:4444/wd/hub',
  specs: ['tooltip.js'],

  onPrepare: function(){
    protractor.loginHelper = require('/Protractor/Helpers/loginToPage.js');

    protractor.logoutHelper = require('/Protractor/Helpers/logout.js');
  }
}