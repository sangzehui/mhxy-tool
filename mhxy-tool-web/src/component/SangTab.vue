<template>
	<div>
		<div class="tab">
			<a v-for="item in items"
			   href="#"
			   :class="classObject(item)"
			   @click="tabSwitch(item)"
			>
				{{item.text}}
			</a>
		</div>
		<div class="sub-tab">
			<template v-for="parentItem in items">
				<a v-for="item in parentItem.items"
				   href="#"
				   :parent="parentItem.id"
				   :class="subClassObject(item, parentItem)"
				   @click="subTabSwitch(item)"
				>
					{{item.text}}
				</a>
			</template>
		</div>
	</div>
</template>

<script>
    export default {
        name: 'tab',
        props: {
            items: Array,
            activeItem: String,
            subActiveItem: String
        },
        data: function () {
            return {
                activeItemId: this.activeItem,
                subActiveItemId: this.subActiveItem
            }
        },
        methods: {
            tabSwitch: function (item) {
                if (this.activeItemId != item.id) {
                    this.activeItemId = item.id;
                    if(item.items.length > 0) {
                        let subItem = item.items[0];
                        this.subActiveItemId = subItem.id;
                        this.$emit('subClassObject', subItem);
                        this.$emit('tabSwitch', subItem);
                    }
                }
            },
            subTabSwitch: function (item) {
                if (this.subActiveItemId != item.id) {
                    this.subActiveItemId = item.id;
                    this.$emit('tabSwitch', item);
                }
            },
            classObject: function (item) {
                let clazz = "col-md-3";
                if (item.id == this.activeItemId) {
                    clazz += " active";
                }
                return clazz;
            },
            subClassObject: function (item, parentItem) {
                let clazz = "";
                if(parentItem.id != this.activeItemId) {
                    clazz += " hidden";
                }
                if (item.id == this.subActiveItemId) {
                    clazz += " active";
                }
                return clazz.trim();
            },
        }
    }
</script>

<style>
	.tab {
		overflow: hidden;
		width: 100%;
		padding: 0;
		margin: 0;
	}

	.tab a {
		color: #000;
		text-decoration: none;
		float: left;
		margin: 5px 10px;
		padding: 10px 40px;
		font-size: 20px;
		background: #ddd;
	}

	.tab .active, .tab a:hover {
		color: #fff;
		background: #39b;
	}

	.sub-tab {
		float: left;
		width: 20%;
	}

	.sub-tab a {
		display: block;
		text-decoration: none;
		border: 1px solid #ddd;
		color: #000;
		padding: 5px 10px;
		margin: 5px 0;
		text-align: center;
	}

	.sub-tab .active, .sub-tab a:hover {
		background: #39b;
		color: #fff;
	}

	.sub-tab .hidden {
		display: none;
	}

</style>