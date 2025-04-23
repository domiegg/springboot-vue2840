const base = {
    get() {
        return {
            url : "http://localhost:8080/xiangmuguanlipingtai/",
            name: "xiangmuguanlipingtai",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xiangmuguanlipingtai/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "政府项目管理平台"
        } 
    }
}
export default base
