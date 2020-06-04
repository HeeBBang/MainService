var main = {
    init : function () {
        var _this = this;
        $('btn-license-generate').on('click', function() {
            _this.licenseGenerate();

        });

    },


    licenseGenerate : function {
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
            data: JSON.stringify(data)
            success: function(data) {
                var result = data;
                return result;
            }
        }).done(function() {
            alert('라이센스 생성중 입니다.');
        }).fail(function(error)) {
            alert(JSON.stringify(error))
        });
    }


}