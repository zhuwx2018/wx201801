var wx = $.extend({},wx);
wx.namespace('wx.changeTheme');
wx.changeTheme = function(themeName) {/* 更换主题 */
	var $easyuiTheme = $('#easyui_theme');
	var url = $easyuiTheme.attr('href');
	var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
	$easyuiTheme.attr('href', href);

	var $iframe = $('iframe');
	if ($iframe.length > 0) {
		for ( var i = 0; i < $iframe.length; i++) {
			var ifr = $iframe[i];
			$(ifr).contents().find('#easyui_theme').attr('href', href);
		}
	}

	$.cookie('easyuiThemeName', themeName, {
		expires : 7
	});
};
if ($.cookie('easyuiThemeName')) {
	wx.changeTheme($.cookie('easyuiThemeName'));
}
