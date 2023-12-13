// 配置路由的地方
import Vue from 'vue'
import VueRouter from 'vue-router'

// 使用插件
Vue.use(VueRouter)

// 用户路由
import Home from '../pages/Home'
import Login from '../pages/Login'
import Register from '../pages/Register'
import TeamList from '../pages/TeamList'
import TeamDetail from '../pages/TeamDetail'
import TeamHistory from '../pages/TeamHistory'
import ResourcesLoad from '../pages/ResourcesLoad'
import ResourcesDown from '../pages/ResourcesDown'
import DownloadRecord from '../pages/DownloadRecord'
import FocusMatch from '../pages/FocusMatch'
import FocusInfo from '../pages/FocusInfo'
import MessageRead from '../pages/MessageRead'
import MessageUnread from '../pages/MessageUnread'
import Join from '../pages/Join'
import New from '../pages/New'
import Info from '../pages/MatchInfo'
import Demo from '../pages/Demo'
import MyPage from '../pages/MyPage'
import FeedBack from '../pages/FeedBack'

// 管理员路由
import HomeAdm from '../pages/Administrator/Home-Adm'
import TeamManage from '../pages/Administrator/TeamManage'
import UserManage from '../pages/Administrator/UserManage'
import MatchManage from '../pages/Administrator/MatchManage'
import AddMatch from '../pages/Administrator/Add'
import LoadManage from '../pages/Administrator/Load'
import DataAnalysis from '../pages/Administrator/DataAnalysis'
import ReadManage from '../pages/Administrator/ReadManage'
import UnReadManage from '../pages/Administrator/UnreadManage'

import NotFound from '../components/404'

// 配置路由
export default new VueRouter({
  routes: [
    {
      path: '/home',
      name: "home",
      component: Home
    },
    {
      path: '/login',
      name: "login",
      component: Login
    },
    {
      path: '/demo',
      name: "demo",
      component: Demo
    },
    {
      path: '/mine',
      name: "mine",
      component: MyPage,
      meta: ['个人中心']
    },
    {
      path: '/feedback',
      name: "feedback",
      component: FeedBack,
      meta: ['反馈中心']
    },
    {
      path: '/register',
      name: "register",
      component: Register
    },
    {
      path: '/teamlist',
      name: "teamlist",
      component: TeamList,
      meta: ['小队大厅']
    },
    {
      path: '/teamhistory',
      name: "teamhistory",
      component: TeamHistory,
      meta: ['我的小队']
    },
    {
      path: '/teamdetail',
      name: "teamdetail",
      component: TeamDetail,
      meta: ['历史队伍详情']
    },
    {
      path: '/resourcesload',
      name: "resourcesload",
      component: ResourcesLoad,
      meta: ['资源上传']
    },
    {
      path: '/resourcesdown',
      name: "resourcesdown",
      component: ResourcesDown,
      meta: ['资源下载']
    },
    {
      path: '/downloadrecord',
      name: "downloadrecord",
      component: DownloadRecord,
      meta: ['下载历史']
    },
    {
      path: '/focusmatch',
      name: "focusmatch",
      component: FocusMatch,
      meta: ['关注的院校']
    },
    {
      path: '/focusinfo',
      name: "focusinfo",
      component: FocusInfo,
      meta: ['关注的信息']
    },
    {
      path: '/messageread',
      name: 'messageread',
      component: MessageRead,
      meta: ['消息列表 / 已读']
    },
    {
      path: '/messageunread',
      name: 'messageunread',
      component: MessageUnread,
      meta: ['消息列表 / 未读']
    },
    {
      path: '/join',
      name: 'join',
      component: Join,
      meta: ["申请入队"]
    },
    {
      path: '/new',
      name: 'new',
      component: New,
      meta: ["新建小队"]
    },
    {
      path: '/info',
      name: 'info',
      component: Info,
      meta: ["考研资讯"]
    },
    {
      path: '/homeadm',
      name: 'homeadm',
      component: HomeAdm,
    },
    {
      path: '/adm-teams',
      name: 'adm-teams',
      component: TeamManage,
      meta: ["队伍管理"]
    },
    {
      path: '/adm-users',
      name: 'adm-users',
      component: UserManage,
      meta: ["用户管理"]
    },
    {
      path: '/adm-matches',
      name: 'adm-matches',
      component: MatchManage,
      meta: ["院校增删"]
    },
    {
      path: '/adm-add',
      name: 'adm-add',
      component: AddMatch,
      meta: ["院校增删"]
    },
    {
      path: '/adm-load',
      name: 'adm-load',
      component: LoadManage,
      meta: ["资源上传"]
    },
    {
      path: '/adm-data',
      name: 'adm-data',
      component: DataAnalysis,
      meta: ["数据统计"]
    },
    {
      path: '/adm-read',
      name: 'adm-read',
      component: ReadManage,
      meta: ["已读"]
    },
    {
      path: '/adm-unread',
      name: 'adm-unread',
      component: UnReadManage,
      meta: ["未读"]
    },
    {
      path: '/',
      redirect: '/login',
      component: Login
    },
    {
      // 404页面
      path: '*',
      name: 'notfound',
      component: NotFound
    }
  ]
})