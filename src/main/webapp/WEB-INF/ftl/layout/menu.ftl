    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${ctx}/user/list.sc">用户列表</a></dd>
                        <dd><a href="javascript:;">审核</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">商品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">品牌列表</a></dd>
                        <dd><a href="javascript:;">商品分类</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">优惠</a></li>
                <li class="layui-nav-item"><a href="">统计</a></li>
            </ul>
        </div>
    </div>
    
