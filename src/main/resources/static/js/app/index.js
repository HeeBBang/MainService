
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