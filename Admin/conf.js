
exports.config = {
  framework: 'jasmine',

  seleniumAddress: 'http://localhost:4444/wd/hub',
  specs: ['coach_management.js'],
  onPrepare: function() {
    var SpecReporter = require('jasmine-spec-reporter'); // npm install jasmine-spec-reporter
    jasmine.getEnv().addReporter(new SpecReporter({displayStacktrace: 'all'}));
  },
  jasmineNodeOpts: {
    showColors: true,
    isVerbose: true
  },
  onPrepare: function(){
    protractor.loginHelper = require('/Protractor/Helpers/loginToPage.js');

    protractor.logoutHelper = require('/Protractor/Helpers/logout.js');

   // protractor.tooltipHelper = require('/Tooltip/tooltip.js');
  }
}