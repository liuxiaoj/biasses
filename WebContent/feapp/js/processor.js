/*

 * 	@brief  : Contains JQuery  / javascript routines for processing request of QR scanning,
 *  server status check, take and upload photo
 */

/**
 * return server status
 */
var serverstatus = function() {
	$("#loading_status").show();
	$.get("qrProcessMgr.do", {
    			command : "server_status"
    		}, function(data) {
    			if (! data.isOk) {
    				alert(data.msg);
    				return;
    			}
    		$("#loading_status").text=data;
}();
/**
 * return server status
 */

var takeUpload = function() {
	$.get("qrProcessMgr.do", {
    			command : "take_upload"
    		}, function(data) {
    			if (! data.isOk) {
    				alert(data.msg);
    				return;
    			}
}();
/*******************************************************************************
 *
 *
 * processor
 *
 *
 ******************************************************************************/
var processor = function() {

	// ///////////////////////////
	// Private Data
	// ///////////////////////////

	var _myApp; // Application object, must be initialized


	// ///////////////////////////
	// Public function
	// ///////////////////////////
	return {

		/**
		 * Initializes the
		 */
		init : function(app) {
			_myApp = app;
		}
	}; // end of public functions

}(); // end workspace





	