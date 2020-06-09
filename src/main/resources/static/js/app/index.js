var firstGrid;


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
	 firstGrid = new ax5.ui.grid();

	/* 그리드 설정 지정 */
	firstGrid.setConfig({
	    target: $('[data-ax5grid="license-grid"]'),

        showLineNumber: true,
        showRowSelector: true,
        multipleSelect: false,
        lineNumberColumnWidth: 40,
        rowSelectorColumnWidth: 27,

	    columns: [
            {key: "id", label: "라이선스 넘버", align: "center"},
            {key: "code", label: "라이선스 코드", align: "center"},
            {key: "type", label: "라이선스 타입", align: "center"},
            {key: "product", label: "라이선스 제품", align: "center"},
            {key: "licensePeriod", label: "라이선스 기간", formatter: "money", align: "center"},
            {key: "beginDate", label: "라이선스 시작 날짜", align: "center", editor: {type: "date"}},
            {key: "endDate", label: "라이선스 종료 날짜", align: "center", editor: {type: "date"}},
            {key: "email", label: "사용자 Email", align: "center"}
	    ]
	});

    /* 테스트용 데이터 생성 */
    /*
    var list = [];
    for (var i = 0; i < 50; i++) {
        list.push({date: "20170101", type: "주유", amount: 25, mileage: (i + 1) * 100, price: 45000, repair: "-", note: "-"});
    }
    */
    /* 그리드에 데이터 설정 */
    //firstGrid.setData(list);

    licenseMain.init();
});


var licenseMain = {

    init : function () {
        var _this = this;
        $('#btn-license-generate').on('click', function() {
            _this.licenseGenerate();
        });
        $('#btn-license-search').on('click', function() {
            _this.licenseSearch();
        });
        $('#btn-license-excel-export').on('click', function() {
            _this.licenseExcelExport();
        });
    },

    licenseGenerate : function (){
        var data = {
            generateNumber : $('#input-generate-count').val(),
            type : $('#input-generate-type').val(),
            product: $('#input-generate-product').val(),
            licensePeriod : $('#input-generate-period').val()
        };

        if(Number(data.generateNumber) == 0)
        {
            alert("라이센스 생성 갯수를 입력해 주세요.");
        }
        else
        {
            $.ajax({
                type: 'POST',
                url: '/api/v1/license/generate',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data),
                success: function(data) {
                    firstGrid.setData(data);
                }
            }).done(function() {
                console.log("라이센스 생성 완료");
            }).fail(function(error) {
                console.log("에러 발생" + JSON.stringify(error))
            });
        }
    },

    licenseSearch : function () {
        var data;

        $.ajax({
            type: 'POST',
            url: '/api/v1/license/search',
            dataType: 'json',
            //contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            success: function(data) {
                firstGrid.setData(data);

                /*
                console.log("라이센스 생성 중");

                firstGrid.addRow({date:201607}, 5);
                firstGrid.addRow({date:201608}, 6);
                firstGrid.addRow({date:201609}, 7);
                */
                /*
                ax5grid.addRow({date:201607}, 3);

                firstGrid.setData(data);
                */
                /*
                data.find("code").each(function() {
                   firstGrid.addRow($.extend({}, firstGrid.list[Math.floor(Math.random() * firstGrid.list.length)], {__index: undefined}));

                });
                */


            }
        }).done(function() {
            console.log("라이센스 생성 완료");
        }).fail(function(error) {
            console.log("에러 발생" + JSON.stringify(error))
        });
    },


    licenseExcelExport : function (){
        firstGrid.exportExcel('LicenseList.xls');
    }




}

