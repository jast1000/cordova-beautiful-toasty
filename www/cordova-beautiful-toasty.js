var exec = require('cordova/exec');

exports.showSuccess = function(message, success, error) {
    exec(success, error, 'cordova-beautiful-toasty', 'showSuccess', [message]);
};