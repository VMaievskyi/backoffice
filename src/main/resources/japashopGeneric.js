
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

$('#createProductForm').on('submit',function (e) {
	e.preventDefault();
    $.ajax({
        url: '/products',
        cache: false,
        type: 'POST',
        contentType: 'application/json',
        data : JSON.stringify($('#createProductForm').serializeObject()),
        success: function(json) {
            alert(json.text());
        }
    });
});