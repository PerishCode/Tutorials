export default {
  setup(props: any) {
    console.log(props)

    return () => (
      <input
        type="text"
        value={props.value}
        onChange={(e: any) => (props.value = e.target.value)}
      />
    )
  },
}
