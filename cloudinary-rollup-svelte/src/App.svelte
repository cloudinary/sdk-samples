<script>
	import {AdvancedImage, responsive, lazyload, placeholder, accessibility} from '@cloudinary/svelte';
	import {CloudinaryImage} from "@cloudinary/base";
	const img = new CloudinaryImage('sample', {cloudName: 'demo'});
	export let name;
</script>

<main>
	<h1>Hello {name}!</h1>
	<p>Visit the <a href="https://svelte.dev/tutorial">Svelte tutorial</a> to learn how to build Svelte apps.</p>
	<AdvancedImage class="image" cldImg={img} plugins={[lazyload(),responsive(), accessibility(), placeholder()]}/>
</main>

<style>
	main {
		text-align: center;
		padding: 1em;
		max-width: 240px;
		margin: 0 auto;
	}

	h1 {
		color: #ff3e00;
		text-transform: uppercase;
		font-size: 4em;
		font-weight: 100;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>
