<template>
	<div class="form-item">
		<label>{{label}}</label>
		<span>
			<slot></slot>
		</span>
	</div>
</template>

<script>
    export default {
        name: 'form-item',
        props: ['label'],
        methods: {}
    }
</script>

<style>
	.form-item {
		padding: 6px 0;
		width: 100%;
		clear: both;
		overflow: hidden;
	}

	.form-item label {
		float: left;
		color: #666;
		margin: 2px 5px;
	}

	.form-item input {
		width: 100%;
		padding: 3px;
		font-size: 16px;
		border: none;
		border-bottom: 1px solid #ccc;
		outline: none;
	}

	.form-item span {
		display: block;
		overflow: hidden;
	}

	.form-item select {
		width: 100%;
		padding: 3px;
		font-size: 16px;
	}

	.form-item .result {
		text-align: right;
		padding: 0 10px;
		display: block;
	}
</style>