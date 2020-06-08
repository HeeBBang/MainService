$(document).ready(function () {
    /* dash(-)로 구분되는 날짜 포맷터 */
    ax5.ui.grid.formatter["date"] = function() {
        var date = this.value;
        if(date.length == 8) {
            return date.substr(0, 4) + "-" + date.substr(4, 2) + "-" + date.substr(6);
        }
        else {
            return date;
        }
    }

    var firstGrid = new ax5.ui.grid();

    /* 그리드 설정 지정 */
    firstGrid.setConfig({
        target: $('[data-ax5grid="first-grid"]'),
        showLineNumber: false,
        showRowSelector: true,
        multipleSelect: false,
        lineNumberColumnWidth: 40,
        rowSelectorColumnWidth: 27,
            columns: [
                {key: "date", label: "날짜", formatter: "date", align: "center"},
                {key: "type", label: "구분", align: "center"},
                {key: "amount", label: "<strong>주유량</strong>", align: "center"},
                {key: "mileage", label: "주행거리(km)", align: "center"},
                {key: "price", label: "금액(원)", formatter: "money", align: "center"},
                {key: "repair", label: "정비내역", align: "center"},
                {key: "note", label: "비고", align: "center"}
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

var main = {
    init : function () {
        var _this = this;
        $('btn-license-generate').on('click', function() {
            _this.licenseGenerate();

        });

    },


    licenseGenerate : function() {
        var data = {
            generateNumber : 10,
            type: "LICENSE_PERMANENT",
            product: "BABY_SIGN",
            licensePeriod : 365
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/license',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            success: function(data) {
                var result = data;
                return result;
            }
        }).done(function() {
            alert('라이센스 생성중 입니다.');
        }).fail(function(error) {
            alert(JSON.stringify(error))
        });
    }


}