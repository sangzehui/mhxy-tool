<template>
	<form-item :label="label">
		<input :value="val"
		       @input="updateValue($event.target.value)"
		>
	</form-item>
</template>

<script>
    import FormItem from './FormItem.vue'

    export default {
        name: 's-input',
        props: ['val', 'label'],
        components: {
            'form-item': FormItem,
        },
        methods: {
            updateValue: function (value) {
                this.$emit('input', value);
            },
        }
    }
</script>

<style>
</style>