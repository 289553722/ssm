layui.use(['layer','form','laydate'], function () {
    var layer = layui.layer,
        form = layui.form,
        laydate = layui.laydate;

    laydate.render({
        elem: '#birthDayStart',
        max: $('#birthDayEnd').val()
    });

    laydate.render({
        elem: '#birthDayEnd',
        ready: function(date){
            this.min = $('#birthDayStart').val();
        }
    });

    form.on('checkbox(checkAll)', function(data){
        var checked = data.elem.checked;
        $('#mainTable tbody td :checkbox').prop('checked', checked);
        if(checked){
            $('#mainTable tbody td .layui-form-checkbox').addClass('layui-form-checked');
            //$('#mainTable tbody td :checkbox').attr('checked','checked');
        }else{
            $('#mainTable tbody td .layui-form-checkbox').removeClass('layui-form-checked');
            //$('#mainTable tbody td :checkbox').removeAttr('checked');
        }
    });
    
    $('#add').on('click',function () {
        layer.msg('add');
    });
    
    $('#batchRemove').on('click',function () {
        var checkObjs = $('#mainTable tbody td :checkbox:checked');
        var idArr = new Array();
        $.each(checkObjs, function (index,item) {
           idArr.push($(item).data('id'));
        });
        var ids = idArr.join();
        layer.msg(ids);
    });
    
    $('#query').on('click',function () {
        $('#queryForm').submit();
    });
});
