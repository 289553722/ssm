    layui.use(['layer', 'form'], function(){
        var layer = layui.layer
            ,form = layui.form;

        form.on('checkbox(checkAll)', function(data){
            var checked = data.elem.checked;
            var checkedObjs = $('form tbody .layui-form-checkbox');
            if(checked){
                checkedObjs.addClass('layui-form-checked');
            }else{
                checkedObjs.removeClass('layui-form-checked');
            }
            
        });



        $('#add').on('click',function () {
            layer.alert('ddd');
        });

        $('#batchRemove').on('click',function () {
            layer.alert('fff');
        });
    });

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#birthDayStart' //指定元素
        });
        //执行一个laydate实例
        laydate.render({
            elem: '#birthDayEnd' //指定元素
        });
    });