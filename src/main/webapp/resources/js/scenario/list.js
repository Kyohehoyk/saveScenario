;(function(){
	var $pages;

	function pagenation(){
		//location.hash は #以降の文字を取得
		$pages.detach().filter(getPage(location.hash)).appendTo("article");
	};

	function getPage(url) {
		if (url.length > 0) {
			// タグを取得できた場合はそのページを設定
			return ".page"+url.slice(1)
		} else {
			// タグを取得できなかった場合は１ページ目を設定
			return ".page1";
		}
	};

	function init() {
		// detach()でDOMを削除
		$pages = $("[data-role='page']").detach();
		// #の値が変わった時にpagenation関数を実行する。
		$(window).on("hashchange", pagenation).trigger("hashchange");
	};
	// 初期実行
	init();
})();
