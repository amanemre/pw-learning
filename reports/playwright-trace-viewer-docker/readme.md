# Docker Container to Host you own Trace Viewer instance

Just https://trace.playwright.dev in a self-hosted docker container.

## Uses

- [Playwright](https://github.com/microsoft/playwright)
- [static-web-server](https://github.com/static-web-server/static-web-server)

## Development

docker build -t pw-traceviewer-docker .

docker run --rm -p 5555:5555 pw-traceviewer-docker
