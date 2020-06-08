$(document).ready(function () {

	/* dash(-)로 구분되는 날짜 포맷터 */
	ax5.ui.grid.formatter["date"] = function() {
		var date = this.value;
		if(date.length == 8) {
			return date.substr(0, 4) + "-" + date.substr(4, 2) + "-" + date.substr(6);
		} else {
			return date;
		}
	}

	/* 그리드 객체 생성 */
	var firstGrid = new ax5.ui.grid();

	/* 그리드 설정 지정 */
	firstGrid.setConfig({
	    target: $('[data-ax5grid="license-grid"]'),

        showLineNumber: true,
        showRowSelector: true,
        multipleSelect: false,
        lineNumberColumnWidth: 40,
        rowSelectorColumnWidth: 27,

	    columns: [
            {key: "date", label: "라이선스 넘버", align: "center"},
            {key: "type", label: "라이선스 코드", align: "center"},
            {key: "amount", label: "라이선스 타입", align: "center"},
            {key: "mileage", label: "라이선스 제품", align: "center"},
            {key: "price", label: "라이선스 기간", formatter: "money", align: "center"},
            {key: "repair", label: "라이선스 시작 날짜", align: "center"},
            {key: "note", label: "라이선스 종료 날짜", align: "center"},
            {key: "note", label: "사용자 Email", align: "center"}
	    ]
	});

    /* 테스트용 데이터 생성 */
    var list = [];
    for (var i = 0; i < 50; i++) {
        list.push({date: "20170101", type: "주유", amount: 25, mileage: (i + 1) * 100, price: 45000, repair: "-", note: "-"});
    }

    /* 그리드에 데이터 설정 */
    firstGrid.setData(list);
});


var licenseMain = {

    init : function () {
        var _this = this;
        $('#btn-license-generate').on('click', function() {
            _this.licenseGenerate();
        });
    },


    licenseGenerate : function (){
        var data = {
            generateNumber : 10,
            type : 0,
            product: 0,
            licensePeriod : 365
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/license/generate',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            success: function(data) {
                alert('라이센스 생성 중 입니다.');
/*
                var commentList = ""
                data.find("code").each(function() {
                    commentList += "<div>";


                })

                var result = data;
                return result;
                */
            }
        }).done(function() {
            alert("라이센스 생성 완료");
        }).fail(function(error) {
            alert("에러 발생" + JSON.stringify(error))
        });
    }


}

licenseMain.readyAx5ui();
licenseMain.init();