<template>
	<div id="app">
		<div id="box">
			<s-title>
				<h1>梦幻西游工具箱</h1>
			</s-title>
			<tab :items="tabItems"
			     :activeItem="tabActiveItem"
			     :subActiveItem="subTabActiveItem"
			     @tabSwitch="tabSwitchEvent"
			>
			</tab>
			<div id="main">
				<component :is="page"></component>
			</div>
		</div>
	</div>
</template>

<script>
    import Vue from 'vue'
    import Tab from './component/SangTab.vue'
    import Title from './component/SangTitle.vue'
    import PersonExpPage from './page/person/ExpPage.vue'
    import PersonPracticePage from './page/person/PracticePage.vue'
    import PetExpPage from './page/pet/ExpPage.vue'
    import FixedPtPage from './page/fixed/PtPage.vue'
    import FixedWddPage from './page/fixed/WddPage.vue'
    import FixedPsPage from './page/fixed/PsPage.vue'
    import FixedDfPage from './page/fixed/DfPage.vue'

    export default {
        name: 'app',
        components: {
            tab: Tab,
            's-title': Title,
            personExpPage: PersonExpPage,
            personPracticePage: PersonPracticePage,
            petExpPage: PetExpPage,
            fixedPtPage: FixedPtPage,
            fixedWddPage: FixedWddPage,
            fixedPsPage: FixedPsPage,
            fixedDfPage: FixedDfPage,
        },
        data: function () {
            return {
                page: PersonExpPage,
                tabItems: [
                    {
                        id: 'person',
                        text: '人物',
                        items: [
                            {id: 'personExp', text: '人物经验', page: 'personExpPage'},
                            {id: 'personPractice', text: '任务修炼', page: 'personPracticePage'},
                        ],
                    },
//                    {
//                        id: 'pet',
//                        text: '召唤兽',
//                        items: [
//                            {id: 'petExp', text: '宠物经验', page: 'petExpPage'},
//                        ]
//                    },
                    {
                        id: 'fixed',
                        text: '固伤计算',
                        items: [
                            {id: 'pt', text: '普陀山', page: 'fixedPtPage'},
                            {id: 'wdd', text: '无底洞', page: 'fixedWddPage'},
                            {id: 'ps', text: '盘丝洞', page: 'fixedPsPage'},
                            {id: 'df', text: '地府', page: 'fixedDfPage'},
                        ]
                    },
                ],
                tabActiveItem: 'person',
                subTabActiveItem: 'personExp',
            };
        },
        methods: {
            tabSwitchEvent: function (item) {
                this.page = item.page;
            }
        }
    }
</script>

<style lang="scss">
	#box {
		width: 650px;
		border: 1px solid #ccc;
		clear: both;
		overflow: hidden;
		padding: 2px;
		margin: 0 auto;
	}

	#main {
		float: left;
		/*height: 620px;*/
		width: 70%;
		padding: 10px;
	}

	.title {
		text-align: center;
	}
</style>
